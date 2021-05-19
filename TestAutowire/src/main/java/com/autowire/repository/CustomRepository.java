package com.autowire.repository;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;

public interface CustomRepository {

	UpdateResult updateStudentSection(int age, String section);

}
