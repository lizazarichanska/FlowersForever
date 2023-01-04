package flower.flowercontinue.flower;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;

    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }
    @GetMapping
    public List<Flower> getFlowers() {
        return flowerRepository.findAll();
    }

    public void addFlowers(Flower flower) {
        Optional<Flower> flowerByType = flowerRepository
                .findFlowerByType(flower.getFlowerType());
        System.out.println(flower);
        flowerRepository.save(flower);
    }

}
