cmake_minimum_required(VERSION 3.1)
project(WinFsNotifier)

if(NOT WIN32)
  message(FATAL_ERROR "Windows only.")
endif()

if (DEFINED ENV{BUILD_NUMBER})
  set(BUILD_NUMBER $ENV{BUILD_NUMBER})
else()
  set(BUILD_NUMBER 9999)
endif()

string(TIMESTAMP YEAR "%Y")

set(CMAKE_C_FLAGS_RELEASE "${CMAKE_C_FLAGS_RELEASE} /MT")

configure_file(${CMAKE_CURRENT_SOURCE_DIR}/fileWatcher3.rc ${CMAKE_CURRENT_BINARY_DIR}/fileWatcher3.rc @ONLY)

add_executable(fsnotifier fileWatcher3.c ${CMAKE_CURRENT_BINARY_DIR}/fileWatcher3.rc)
