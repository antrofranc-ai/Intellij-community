class J {
    fun foo(b: Byte, c: Char, s: Short, i: Int, l: Long) {
        println(b.toInt() shr i)
        println(b.toInt() ushr i)
        println(b.toInt() shl i)
        println(b.toInt() shl l.toInt())
        println(b.toInt() shl 5)
        println(5 shl b.toInt())
        println(b.toInt() and b.toInt())
        println(b.toInt() and 0x01)
        println(b.toInt() or b.toInt())
        println(0x01 or b.toInt())
        println(b.toInt() xor b.toInt())
        println(5 /*operand '5'*/ shl  /* left shift */b.toInt() /*operand 'b'*/)
        println( /*operand 'b'*/b.toInt() xor  /* xor */b.toInt() /*operand 'b'*/)
        println(c.code shr i)
        println(c.code ushr i)
        println(c.code shl i)
        println(c.code shl l.toInt())
        println(c.code shl 5)
        println(5 shl c.code)
        println(c.code and c.code)
        println(c.code and 0x01)
        println(c.code or c.code)
        println(0x01 or c.code)
        println(c.code xor c.code)
        println(s.toInt() shr i)
        println(s.toInt() ushr i)
        println(s.toInt() shl i)
        println(s.toInt() shl l.toInt())
        println(s.toInt() shl 5)
        println(5 shl s.toInt())
        println(s.toInt() and s.toInt())
        println(s.toInt() and 0x01)
        println(s.toInt() or s.toInt())
        println(0x01 or s.toInt())
        println(s.toInt() xor s.toInt())
        println(i shr i)
        println(i ushr i)
        println(i shl i)
        println(i shl l.toInt())
        println(i shl 5)
        println(5 shl i)
        println(i and i)
        println(i and 0x01)
        println(i or i)
        println(0x01 or i)
        println(i xor i)
        println(l shr i)
        println(l ushr i)
        println(l shl i)
        println(l shl l.toInt())
        println(l shl 5)
        println(5 shl l.toInt())
        println(l and l)
        println(l and 0x01L)
        println(l or l)
        println(0x01L or l)
        println(l xor l)
    }
}