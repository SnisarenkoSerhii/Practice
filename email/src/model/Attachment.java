package model;

/**
 * Created by Sergey on 04.12.2015.
 */
public class Attachment {
    private byte[] data;
    private String fileName;

    public Attachment(byte[] data, String fileName) {
        this.data = data;
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
