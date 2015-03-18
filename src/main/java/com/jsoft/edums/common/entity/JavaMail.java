package com.jsoft.edums.common.entity;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {

	private String host = "";//SMTP服务器
	private String user = "";//发送邮箱的邮箱名
	private String password = ""; //发送邮箱的密码

	public void setHost(String host) {
		this.host = host;
	}

	public void setAccount(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public void send(String from, String to, String content) {
		Properties props = new Properties();
		props.put("smtp.qq.com", host); // 指定SMTP服务器（qq邮箱）
		props.put("mail.smtp.auth", "true");// 指定是否需要SMTP验证
		try {
			Session mailSession = Session.getDefaultInstance(props);

			Message message = new MimeMessage(mailSession);

			message.setFrom(new InternetAddress(from)); // 发件人
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to)); // 收件人
			String subject="吉软重要信息！";
			message.setSubject(subject);// 邮件主题
			message.setText(content); // 邮件内容

			message.saveChanges();
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

    /**
     * 发送邮件时调用
     * @param fromEmailName	发送者邮箱名
     * @param fromEmailPassword	发送者邮箱密码
     * @param toEmailName	接收者邮箱名
     * @param message	信息
     * @author 乔弘扬
     */
	public void sendMail(String fromEmailName,String fromEmailPassword,String toEmailName, String message) {
		JavaMail sm = new JavaMail();
		sm.setHost("smtp.qq.com"); // 指定要使用的邮件服务器
		sm.setAccount(fromEmailName, fromEmailPassword); // 指定账号和密码
		sm.send(fromEmailName, toEmailName, message);
	}
}
