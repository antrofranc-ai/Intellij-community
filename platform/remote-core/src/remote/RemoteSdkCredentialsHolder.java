// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.remote;

import com.intellij.openapi.util.NlsSafe;
import com.intellij.remote.ext.CredentialsManager;
import com.intellij.util.PathMappingSettings;
import org.jdom.Element;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RemoteSdkCredentialsHolder extends RemoteCredentialsHolder implements RemoteSdkCredentials {

  @NotNull
  private final RemoteSdkPropertiesHolder myRemoteSdkProperties;

  public RemoteSdkCredentialsHolder(@NotNull final String defaultHelpersDirName) {
    myRemoteSdkProperties = new RemoteSdkPropertiesHolder(defaultHelpersDirName);
  }

  public static String constructSshCredentialsSdkFullPath(@NotNull RemoteSdkCredentials cred) {
    @NlsSafe StringBuilder builder = new StringBuilder();
    if (cred.isRunAsRootViaSudo()) {
      builder.append("sudo+");
    }
    return builder
      .append(getCredentialsString(cred))
      .append(cred.getInterpreterPath())
      .toString();
  }

  /**
   * Extracts interpreter path from full path generated by method getFullInterpreterPath
   * Returns fullPath as fallback
   * <p/>
   * Based on the statement that host can't contain colon(:) symbol
   */
  public static String getInterpreterPathFromFullPath(String fullPath) {
    if (fullPath.startsWith(SSH_PREFIX)) {
      fullPath = fullPath.substring(SSH_PREFIX.length());
      int index = fullPath.indexOf(":");
      if (index != -1) {
        fullPath = fullPath.substring(index + 1); // it is like 8080/home/user or 8080C:\Windows
        index = 0;
        while (index < fullPath.length() && Character.isDigit(fullPath.charAt(index))) {
          index++;
        }
        if (index < fullPath.length()) {
          return fullPath.substring(index);
        }
      }
    }

    return fullPath;
  }


  @NotNull
  public RemoteSdkPropertiesHolder getRemoteSdkProperties() {
    return myRemoteSdkProperties;
  }

  @Override
  public String getInterpreterPath() {
    return myRemoteSdkProperties.getInterpreterPath();
  }

  @Override
  public void setInterpreterPath(String interpreterPath) {
    myRemoteSdkProperties.setInterpreterPath(interpreterPath);
  }

  @Override
  public String getHelpersPath() {
    return myRemoteSdkProperties.getHelpersPath();
  }

  @Override
  public void setHelpersPath(String helpersPath) {
    myRemoteSdkProperties.setHelpersPath(helpersPath);
  }

  @Override
  public String getDefaultHelpersName() {
    return myRemoteSdkProperties.getDefaultHelpersName();
  }

  @NotNull
  @Override
  public PathMappingSettings getPathMappings() {
    return myRemoteSdkProperties.getPathMappings();
  }

  @Override
  public void setPathMappings(@Nullable PathMappingSettings pathMappings) {
    myRemoteSdkProperties.setPathMappings(pathMappings);
  }

  @Override
  public boolean isHelpersVersionChecked() {
    return myRemoteSdkProperties.isHelpersVersionChecked();
  }

  @Override
  public void setHelpersVersionChecked(boolean helpersVersionChecked) {
    myRemoteSdkProperties.setHelpersVersionChecked(helpersVersionChecked);
  }

  @Override
  public String getFullInterpreterPath() {
    return constructSshCredentialsSdkFullPath(this);
  }

  @Override
  public void setSdkId(String sdkId) {
    myRemoteSdkProperties.setSdkId(sdkId);
  }

  @Override
  public String getSdkId() {
    return myRemoteSdkProperties.getSdkId();
  }

  @Override
  public boolean isValid() {
    return myRemoteSdkProperties.isValid();
  }

  @Override
  public void setValid(boolean valid) {
    myRemoteSdkProperties.setValid(valid);
  }

  @Override
  public boolean isRunAsRootViaSudo() {
    return myRemoteSdkProperties.isRunAsRootViaSudo();
  }

  @Override
  public void setRunAsRootViaSudo(boolean runAsRootViaSudo) {
    myRemoteSdkProperties.setRunAsRootViaSudo(runAsRootViaSudo);
  }

  public static boolean isRemoteSdk(@Nullable String path) {
    if (path != null) {
      for (CredentialsType<?> type : CredentialsManager.getInstance().getAllTypes()) {
        if (type.hasPrefix(path)) {
          return true;
        }
      }
    }
    return false;
  }


  @Override
  public void load(Element element) {
    super.load(element);

    myRemoteSdkProperties.load(element);
  }

  @Override
  public void save(Element rootElement) {
    super.save(rootElement);

    myRemoteSdkProperties.save(rootElement);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    RemoteSdkCredentialsHolder holder = (RemoteSdkCredentialsHolder)o;

    if (!getLiteralPort().equals(holder.getLiteralPort())) return false;
    if (isStorePassphrase() != holder.isStorePassphrase()) return false;
    if (isStorePassword() != holder.isStorePassword()) return false;
    if (getAuthType() != holder.getAuthType()) return false;
    if (!getHost().equals(holder.getHost())) return false;
    if (getPassphrase() != null ? !getPassphrase().equals(holder.getPassphrase()) : holder.getPassphrase() != null) return false;
    if (getPassword() != null ? !getPassword().equals(holder.getPassword()) : holder.getPassword() != null) return false;
    if (!getPrivateKeyFile().equals(holder.getPrivateKeyFile())) {
      return false;
    }
    if (getUserName() != null ? !getUserName().equals(holder.getUserName()) : holder.getUserName() != null) return false;

    if (!myRemoteSdkProperties.equals(holder.myRemoteSdkProperties)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = getHost().hashCode();
    result = 31 * result + getLiteralPort().hashCode();
    result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
    result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
    result = 31 * result + getAuthType().hashCode();
    result = 31 * result + getPrivateKeyFile().hashCode();
    result = 31 * result + (getPassphrase() != null ? getPassphrase().hashCode() : 0);
    result = 31 * result + (isStorePassword() ? 1 : 0);
    result = 31 * result + (isStorePassphrase() ? 1 : 0);
    result = 31 * result + myRemoteSdkProperties.hashCode();
    return result;
  }

  @Override
  @NonNls
  public String toString() {
    return "RemoteSdkDataHolder" +
           "{getHost()='" +
           getHost() +
           '\'' +
           ", getLiteralPort()=" +
           getLiteralPort() +
           ", getUserName()='" +
           getUserName() +
           '\'' +
           ", myInterpreterPath='" +
           getInterpreterPath() +
           '\'' +
           ", isRunAsRootViaSudo=" +
           isRunAsRootViaSudo() +
           ", myHelpersPath='" +
           getHelpersPath() +
           '\'' +
           '}';
  }

  public void copyRemoteSdkCredentialsTo(RemoteSdkCredentialsHolder to) {
    super.copyRemoteCredentialsTo(to);
    myRemoteSdkProperties.copyTo(to.getRemoteSdkProperties());
  }
}