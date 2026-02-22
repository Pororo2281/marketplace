package product_service.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product_service.demo.Entity.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,Long> {

}
