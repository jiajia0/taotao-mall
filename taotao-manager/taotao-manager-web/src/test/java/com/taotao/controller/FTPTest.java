package com.taotao.controller;

import com.taotao.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Ftp服务器测试
 * @Author Leafage
 * @Date 2018/2/23 22:49
 **/
public class FTPTest {
    @Test
    public void testFtpClient() throws IOException {
        // 创建一个FtpClient对象
        FTPClient ftpClient = new FTPClient();
        // 创建ftp连接
        ftpClient.connect("192.168.136.128", 21);
        // 登陆ftp服务器，使用用户名和密码
        ftpClient.login("root","leafage");
        // 上传文件
        // 读取本地文件
        FileInputStream fileInputStream = new FileInputStream("G:\\file\\test_ftpclient.jpg");
        // 设置上传路径
        ftpClient.changeWorkingDirectory("/opt/images");
        // 修改上传文件的格式，将其修改为二进制，默认使用文本格式
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        // 参数：服务端名称和文件流
        ftpClient.storeFile("ftpclient.jpg", fileInputStream);
        // 关闭连接
        ftpClient.logout();
    }

    @Test
    public void testFtpUtils() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("G:\\file\\test_ftputils.jpg");
        FtpUtil.uploadFile("192.168.136.128", 21, "root", "leafage", "/opt/images", "", "testutils.jpg", fileInputStream);
    }

    @Test
    public void testFtpUtilsDowonload() {
        FtpUtil.downloadFile("192.168.136.128", 21, "root", "leafage", "/opt/images","1.jpg", "G:\\file\\","dowonload.jpg");
    }

}
