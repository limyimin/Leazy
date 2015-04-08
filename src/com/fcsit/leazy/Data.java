package com.fcsit.leazy;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {

	private String gender;
	private String username;
	private String password;
	private int age;
	private int weight;
	private int height;
	private int id;
	private int calories;
	private int calories_burned;
	private int calories_pedo;
	private float bmi;

	

	public Data() {
		// TODO Auto-generated constructor stub
	}
	
	public Data(String userName, String password, int age, int weight,int height){
		this.username = userName;
		this.password = password;
		this.age = age;
		this.weight = weight;
		this.height = height;
//		this.bmi = bmi;
		
	}

	public float calBMI(int weight, int height) {
		// TODO Auto-generated constructor stub
		float bmi = (float)weight / (((float)height/100*(float)height/100));
		return bmi;
	}

	public int getCaloriesBurned() {
		return calories_burned;
	}

	public void setCaloriesBurned(int calories_burned) {
		this.calories_burned = calories_burned;
	}

	public int getCaloriesPedo() {
		return calories_pedo;
	}

	public void setCaloriesPedo(int calories_pedo) {
		this.calories_pedo = calories_pedo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public float getBmi() {
		return bmi;
	}

	public void setBmi(int bmi) {
		this.bmi = bmi;
	}

	protected Data(Parcel in) {
		gender = in.readString();
		username = in.readString();
		password = in.readString();
		age = in.readInt();
		weight = in.readInt();
		height = in.readInt();
		id = in.readInt();
		calories = in.readInt();
		calories_burned = in.readInt();
		calories_pedo = in.readInt();
		bmi = in.readInt();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(gender);
		dest.writeString(username);
		dest.writeString(password);
		dest.writeInt(age);
		dest.writeInt(weight);
		dest.writeInt(height);
		dest.writeInt(id);
		dest.writeInt(calories);
		dest.writeInt(calories_burned);
		dest.writeInt(calories_pedo);
		dest.writeFloat(bmi);
	}

	@SuppressWarnings("unused")
	public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
		@Override
		public Data createFromParcel(Parcel in) {
			return new Data(in);
		}

		@Override
		public Data[] newArray(int size) {
			return new Data[size];
		}
	};
}