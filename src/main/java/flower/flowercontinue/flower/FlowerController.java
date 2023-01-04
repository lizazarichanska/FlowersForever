package flower.flowercontinue.flower;

import flower.flowercontinue.delivery.DHLDelivery;
import flower.flowercontinue.delivery.Delivery;
import flower.flowercontinue.delivery.PostDelivery;
import flower.flowercontinue.flower.Flower;
import flower.flowercontinue.flower.FlowerService;
import flower.flowercontinue.payment.CreditCardPayment;
import flower.flowercontinue.payment.PayPalPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/flowers")
public class FlowerController {
    private FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping
    public List<Flower> getFlowers() {
        return flowerService.getFlowers();
    }

    @PostMapping
    public void addFlowers(@RequestBody Flower flower) { flowerService.addFlowers(flower); }

    @RequestMapping("/delivery")
    public List<String> getDelivery() {
        DHLDelivery delivery1 = new DHLDelivery();
        PostDelivery delivery2 = new PostDelivery();
        String result1 = "DHLDelivery. ";
        result1 += "{ Transition Costs:= " + delivery1.transitionCosts()*100 + "% }";
        String result2 = "PostDelivery. ";
        result2 += "{ Transition Costs:= " + delivery2.transitionCosts()*100 + "% }";
        return List.of(result1, result2);
    }

    @RequestMapping("/payments")
    public List<String> getPayments() {
        PayPalPayment payment1 = new PayPalPayment();
        CreditCardPayment payment2 = new CreditCardPayment();
        String result1 = "CreditCardPayment. ";
        result1 += "{ Fee:= " + payment2.fee()*100 + "% }";
        String result2 = "PayPalPayment. ";
        result2 += "{ Fee:= " + payment1.fee()*100 + "% }";
        return List.of(result1, result2);
    }
}
