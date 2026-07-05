package com.iss.pojos;

import com.iss.MyEnums.Status;

public record Order(int id, String productName, int quantity, double price, Status status) {
}
