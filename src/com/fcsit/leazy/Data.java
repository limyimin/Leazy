package com.fcsit.leazy;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {

	private String gender, food_name;
	private int age, weight, height, id, calories;

	public Data() {

		// TODO Auto-generated constructor stub
	}

	public Data(String food_name, int calories) {

		this.food_name = food_name;
		this.calories = calories;
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

	public String getFoodName() {
		return food_name;
	}

	public void setFoodName(String food_name) {
		this.food_name = food_name;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub

	}

}
