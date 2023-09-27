package com.example.retro_care.home.controller;

import com.example.retro_care.home.dto.MedicineForHomePageDTO;
import com.example.retro_care.home.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home")
@CrossOrigin
public class HomeController {
    @Autowired
    private IHomeService homeService;

    /**
     * Searches for medicines based on a keyword and type.
     *
     * @param keyword The search string obtained from the API request parameter.
     * @param type    The kind of medicine obtained from the API request parameter.
     * @return A list of medicines related to the keyword and type that are not flagged as deleted.
     * @author HuyL
     */
    @GetMapping
    public ResponseEntity<List<MedicineForHomePageDTO>> findMedicineForHomepage(
            @RequestParam(defaultValue = "", required = false) String keyword,
            @RequestParam(defaultValue = "", required = false) String type) {
        List<MedicineForHomePageDTO> medicines = homeService.findMedicineForHomepage(keyword, type);
        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    /**
     * Finds favorite medicines based on their sale quantities.
     *
     * @return The 30 medicines with the highest sale quantities.
     * @author HuyL
     */
    @GetMapping("/favorite")
    public ResponseEntity<List<MedicineForHomePageDTO>> findFavoriteMedicineForHomepage() {
        List<MedicineForHomePageDTO> medicines = homeService.findFavoriteMedicineForHomepage();
        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    /**
     * Retrieves a paginated list of medicines for the home page.
     *
     * @param page          The page number for pagination.
     * @param limit         The maximum number of items per page.
     * @param keyword       The search keyword obtained from the API request parameter.
     * @param type          The kind of medicine obtained from the API request parameter.
     * @param sortDirection The sorting direction (asc or desc) obtained from the API request parameter.
     * @param sortBy        The field by which to sort the results, obtained from the API request parameter.
     * @return A paginated list of medicines based on the provided parameters.
     * @author HuyL
     */
    @GetMapping("/list-page")
    public ResponseEntity<Page<MedicineForHomePageDTO>> getListMedicineWithPagination(@RequestParam(defaultValue = "0", required = false) Integer page,
                                                                                      @RequestParam(defaultValue = "8", required = false) Integer limit,
                                                                                      @RequestParam(defaultValue = "", required = false) String keyword,
                                                                                      @RequestParam(defaultValue = "", required = false) String type,
                                                                                      @RequestParam(defaultValue = "asc", required = false) String sortDirection,
                                                                                      @RequestParam(defaultValue = "price", required = false) String sortBy) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, limit, sort);
        Page<MedicineForHomePageDTO> medicines = homeService.getListMedicineWithPagination(keyword, type, pageable);
        if (medicines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }
}
