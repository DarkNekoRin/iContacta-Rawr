package com.ibk.rawr.model;

public class ResponseVenta {
private int messageCode;
private String message;
private VentaBody body;
public int getMessageCode() {
	return messageCode;
}
public void setMessageCode(int messageCode) {
	this.messageCode = messageCode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public VentaBody getBody() {
	return body;
}
public void setBody(VentaBody body) {
	this.body = body;
}


}
