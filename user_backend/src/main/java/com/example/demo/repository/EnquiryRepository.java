package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Enquiry;

public interface EnquiryRepository  extends JpaRepository<Enquiry, Integer> {

}
