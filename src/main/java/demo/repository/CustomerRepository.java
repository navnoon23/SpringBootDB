package demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.bean.Customer;


@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	
	@Modifying
	@Transactional
	@Query("delete from Customer c where c.id = :customerId")
	void deleteById(@Param("customerId")Long customerId);

}
