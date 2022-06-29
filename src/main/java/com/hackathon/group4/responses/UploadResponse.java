package com.hackathon.group4.responses;

public class UploadResponse {
  private final String fileName;

  public UploadResponse(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }
}