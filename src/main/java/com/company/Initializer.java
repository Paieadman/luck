package com.company;

import com.company.entity.Comment;
import com.company.entity.Dish;
import com.company.entity.Photo;
import com.company.repository.CommentRepository;
import com.company.repository.DishRepository;
import com.company.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Initializer {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PhotoRepository photoRepository;

    public Initializer() {
    }


    public void initialize() {

    }

    public void initializeDish() {
        dishRepository.save(new Dish("Креветки гриль со свежим салатом и овощами", 220, "Под горчично-бальзамическим дрессингом", "https://media.maximilians.ru/main/cuisine/tsezar/krev-gril-380x270.jpg", "Salad"));
        dishRepository.save(new Dish("Брауни шоколадный", 95, "С обжаренным грецким орехом", "https://media.maximilians.ru/main/cuisine/malinovyj-muss/brauni-380x270.jpg", "Deserts"));
        dishRepository.save(new Dish("Запеченные свиные ребрышки барбекю", 550, "С картофельными дольками, кукурузой и маринованными огурчиками", "https://media.maximilians.ru/main/cuisine/svinaya-rulka-na-dve-persony/zap-rebra-380x270.jpg", "Hot"));
        dishRepository.save(new Dish("Гречневая каша", 135, "С томатами и капустой", "https://img0.liveinternet.ru/images/attach/c/6/91/658/91658136_boiled_buckwheat.jpg", "SideDish"));
        dishRepository.save(new Dish("Банановый коктейль", 80, "Со льдом", "https://koktelclub.ru/wp-content/uploads/2018/03/3-380x357-380x270.jpg", "Drinks"));
    }

    public void initializeComments() {
        commentRepository.save(new Comment("Виталий", "Отлично посидели"));
        commentRepository.save(new Comment("Евгений", "Было здорово"));
        commentRepository.save(new Comment("Василий", "Незабываемо провели время"));
    }

    public void initializePhoto() {
        photoRepository.save(new Photo("https://media.maximilians.ru/kazan/page/about-maximilians/interior.jpg"));
        photoRepository.save(new Photo("https://media.maximilians.ru/chel/page/about-maximilians/interior-chlb.jpg"));
        photoRepository.save(new Photo("https://media.maximilians.ru/nsk/page/about-maximilians/interior-nsk.jpg"));
        photoRepository.save(new Photo("https://media.maximilians.ru/ekb/page/about-maximilians/interior-ekb.jpg"));
    }
}
