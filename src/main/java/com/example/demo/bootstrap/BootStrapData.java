package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<InhousePart> parts = (List<InhousePart>) inhousePartRepository.findAll();
        if (parts.isEmpty()) {
            InhousePart flour = new InhousePart(1, "Flour", 5.00, 100, 5, 100);
            inhousePartRepository.save(flour);
            InhousePart sugar = new InhousePart(2, "Sugar", 3.00, 100, 5, 100);
            inhousePartRepository.save(sugar);
            InhousePart frosting = new InhousePart(3, "Frosting", 4.00, 100, 5, 100);
            inhousePartRepository.save(frosting);
        }

        List<OutsourcedPart> outParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        if (outParts.isEmpty()) {
            OutsourcedPart milk = new OutsourcedPart(40, "Milk", 4.00, 100, "Dairy Farms INC", 5, 100);
            outsourcedPartRepository.save(milk);
            OutsourcedPart eggs = new OutsourcedPart(41, "Eggs", 2.00, 100, "Eggman Company", 5, 100);
            outsourcedPartRepository.save(eggs);
        }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */
        List<Product> products = (List<Product>) productRepository.findAll();
        if (products.isEmpty()) {
            Product vanilla = new Product(100, "Vanilla Cake", 20.00, 5);
            Product choco = new Product(101, "Chocolate Cake", 20.00, 5);
            Product marble = new Product(102, "Marble Cake", 25.00, 5);
            Product eggFree = new Product(103, "Egg Free Cake", 22.00, 5);
            Product dairyFree = new Product(104, "Dairy Free Cake", 25.00, 5);
            productRepository.save(vanilla);
            productRepository.save(choco);
            productRepository.save(marble);
            productRepository.save(eggFree);
            productRepository.save(dairyFree);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
