package org.jbulletin.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.apache.commons.io.IOUtils;

@Entity
public class UserDetails implements Serializable {

    private static final long serialVersionUID = -6994664867741148954L;

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String name;

    private String password;

    private int postCount;

    @Lob
    private byte[] avatar;

    private static byte[] defaultAvatar;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public int getPostCount() {
	return postCount;
    }

    public void setPostCount(int postCount) {
	this.postCount = postCount;
    }

    public byte[] getAvatar() {
	return avatar;
    }

    public void setAvatar(byte[] avatar) {
	this.avatar = avatar;
    }

    public byte[] getCurrentAvatar() throws IOException {

	if (defaultAvatar == null) {
	    InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("/default-avatar.png");
	    
	    defaultAvatar = IOUtils.toByteArray(in);
	}
	
	byte[] userAvatar = getAvatar();
	if(userAvatar == null)
	{
	    return defaultAvatar;
	}
	else
	{
	    System.out.println("returning userAvatar");
	    return userAvatar;
	}
    }
}
