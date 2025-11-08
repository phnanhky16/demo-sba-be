package com.example.sba301_fa25_be_SE184884.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sba301_fa25_be_SE184884.entity.FlowerFamilies;
import com.example.sba301_fa25_be_SE184884.entity.Flowers;
import com.example.sba301_fa25_be_SE184884.entity.SystemAccounts;
import com.example.sba301_fa25_be_SE184884.repository.FlowerFamiliesRepository;
import com.example.sba301_fa25_be_SE184884.repository.FlowersRepository;
import com.example.sba301_fa25_be_SE184884.repository.SystemAccountsRepository;

@Component
public class DataInit implements CommandLineRunner {

    @Autowired
    private SystemAccountsRepository systemAccountsRepository;

    @Autowired
    private FlowerFamiliesRepository flowerFamiliesRepository;

    @Autowired
    private FlowersRepository flowersRepository;

    @Override
    public void run(String... args) throws Exception {

        List<SystemAccounts> accounts = new ArrayList<>();

        SystemAccounts account1 = new SystemAccounts();
        account1.setUsername("admin123");
        account1.setEmail("admin@globalflower.com");
        account1.setPassword("@3");
        account1.setRole(1);
        account1.setActive(true);
        accounts.add(account1);

        SystemAccounts account2 = new SystemAccounts();
        account2.setUsername("modjose");
        account2.setEmail("joae@globalflower.com");
        account2.setPassword("@3");
        account2.setRole(2);
        account2.setActive(true);
        accounts.add(account2);

        SystemAccounts account3 = new SystemAccounts();
        account3.setUsername("dev_ops");
        account3.setEmail("dev@globalflower.com");
        account3.setPassword("@3");
        account3.setRole(3);
        account3.setActive(true);
        accounts.add(account3);
        
        systemAccountsRepository.saveAll(accounts);

        List<FlowerFamilies> families = new ArrayList<>();
        
        FlowerFamilies family1 = new FlowerFamilies();
        family1.setFamilyName("Rosaceae");
        family1.setDescription("The rose family, includes roses, strawberries, and apples.");
        family1.setNumberOfSpecies(2830);
        families.add(family1);
        
        FlowerFamilies family2 = new FlowerFamilies();
        family2.setFamilyName("Asteraceae");
        family2.setDescription("The aster family, includes sunflowers, daisies, and chrysanthemums.");
        family2.setNumberOfSpecies(32000);
        families.add(family2);
        
        FlowerFamilies family3 = new FlowerFamilies();
        family3.setFamilyName("Lamiaceae");
        family3.setDescription("The mint family, includes lavender, basil, and rosemary.");
        family3.setNumberOfSpecies(7800);
        families.add(family3);
        
        flowerFamiliesRepository.saveAll(families);

        List<Flowers> flowers = new ArrayList<>();
        
        Flowers flower1 = new Flowers();
        flower1.setCommonName("Rose");
        flower1.setScientificName("Rosa indica");
        flower1.setFamily(family1);
        flower1.setColor("Red");
        flower1.setBloomSeason("Spring, Summer");
        flower1.setWateringNeeds("Medium");
        flower1.setMedicinalUses("Used in skincare and relaxation therapies.");
        flowers.add(flower1);
        
        Flowers flower2 = new Flowers();
        flower2.setCommonName("Sunflower");
        flower2.setScientificName("Helianthus annuus");
        flower2.setFamily(family2);
        flower2.setColor("Yellow");
        flower2.setBloomSeason("Summer");
        flower2.setWateringNeeds("Low");
        flower2.setMedicinalUses("Produces sunflower oil, beneficial for heart health.");
        flowers.add(flower2);
        
        flowersRepository.saveAll(flowers);
    }

}
