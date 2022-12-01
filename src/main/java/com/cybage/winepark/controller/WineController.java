package com.cybage.winepark.controller;

import com.cybage.winepark.service.WineService;
import com.cybage.winepark.domain.Wine;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wine")
@Slf4j
@AllArgsConstructor
public class WineController {
    WineService wineService;

    @GetMapping("getAllWines")
    public ResponseEntity<List<Wine>> getAllWines() {
        log.info("CONTROLLER: getAllWines");
        List<Wine> wines = wineService.getAllWines();
        return new ResponseEntity<>(wines, HttpStatus.OK);
    }

    @GetMapping("getWineById/{id}")
    public  ResponseEntity<Wine> getWineById(@PathVariable("id") Integer id) {
        log.info("CONTROLLER: getWineById");
        Wine wine = wineService.getWineById(id);
        return new ResponseEntity<>(wine, HttpStatus.OK);
    }

    @PostMapping("register")
    public  ResponseEntity<String> addWine(@RequestBody Wine wine) {
        log.info("CONTROLLER: addWine");
        wineService.addWine(wine);
        return new ResponseEntity<>("wine added successfully...", HttpStatus.OK);
    }

    @PutMapping("updateWine/{id}")
    public  ResponseEntity<String> updateWine(@PathVariable("id") Integer id,@RequestBody Wine wine) {
        log.info("CONTROLLER: updateWine");
        wine.setWineId(id);
        wineService.updateWine(wine);
        return new ResponseEntity<>("wine updated successfully...", HttpStatus.OK);
    }



    @DeleteMapping("deleteWine/{id}")
    public  ResponseEntity<String> deleteWine(@PathVariable("id") Integer id) {
        log.info("CONTROLLER: deleteWine");
        wineService.deleteWine(id);
        return new ResponseEntity<>("wine deleted successfully...", HttpStatus.OK);
    }

}
