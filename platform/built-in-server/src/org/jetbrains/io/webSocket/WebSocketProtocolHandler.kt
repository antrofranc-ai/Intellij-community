// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.io.webSocket

import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.handler.codec.http.FullHttpResponse
import io.netty.handler.codec.http.websocketx.*
import io.netty.util.CharsetUtil
import io.netty.util.ReferenceCountUtil
import org.jetbrains.builtInWebServer.LOG
import org.jetbrains.io.NettyUtil

abstract class WebSocketProtocolHandler : ChannelInboundHandlerAdapter() {
  final override fun channelRead(context: ChannelHandlerContext, message: Any) {
    // Pong frames need to get ignored
    when (message) {
      !is WebSocketFrame, is PongWebSocketFrame -> ReferenceCountUtil.release(message)
      is PingWebSocketFrame -> context.channel().writeAndFlush(PongWebSocketFrame(message.content()))
      is CloseWebSocketFrame -> closeFrameReceived(context.channel(), message)
      is TextWebSocketFrame -> {
        try {
          textFrameReceived(context.channel(), message)
        }
        finally {
          // client should release buffer as soon as possible, so, message could be released already
          if (message.refCnt() > 0) {
            message.release()
          }
        }
      }
      else -> throw UnsupportedOperationException("${message.javaClass.name} frame types not supported")
    }
  }

  protected abstract fun textFrameReceived(channel: Channel, message: TextWebSocketFrame)

  protected open fun closeFrameReceived(channel: Channel, message: CloseWebSocketFrame) {
    channel.close()
    message.release()
  }

  @Suppress("OverridingDeprecatedMember")
  override fun exceptionCaught(context: ChannelHandlerContext, cause: Throwable) {
    NettyUtil.logAndClose(cause, LOG, context.channel())
  }
}

open class WebSocketProtocolHandshakeHandler(private val handshaker: WebSocketClientHandshaker) : ChannelInboundHandlerAdapter() {
  final override fun channelRead(context: ChannelHandlerContext, message: Any) {
    val channel = context.channel()
    if (!handshaker.isHandshakeComplete) {
      try {
        handshaker.finishHandshake(channel, message as FullHttpResponse)
        val pipeline = channel.pipeline()
        pipeline.replace(this, "aggregator", WebSocketFrameAggregator(NettyUtil.MAX_CONTENT_LENGTH))
        // https codec is removed by finishHandshake
        completed()
        return
      }
      finally {
        ReferenceCountUtil.release(message)
      }
    }

    if (message is FullHttpResponse) {
      throw IllegalStateException("Unexpected FullHttpResponse (getStatus=${message.status()}, content=${message.content().toString(CharsetUtil.UTF_8)})")
    }

    context.fireChannelRead(message)
  }

  protected open fun completed() {
  }
}