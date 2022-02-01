package com.project.hms.service;

import java.util.List;

import com.project.hms.entity.Bill;

public interface BillService {
	List<Bill> getAllBills();

	Bill saveBill(Bill bill);

	Bill getBillById(Integer id);

	Bill updateBill(Bill bill);

	void deleteBillById(Integer id);

}
