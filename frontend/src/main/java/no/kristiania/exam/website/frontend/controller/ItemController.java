package no.kristiania.exam.website.frontend.controller;

import no.kristiania.exam.website.website.backend.entity.Item;
import no.kristiania.exam.website.website.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ItemController implements Serializable {

    @Autowired
    private ItemService itemService;

    private final int number_of_ranks = 20;
    private Long selectedItemId;
    private List<Item> items;
    public Long itemId;

    public List<Item> getItemsByCategory(String category){
        return itemService.sortByCategory(category);
    }

    public String selectItemToDetails(Long itemId){
        this.itemId = itemId;
        selectedItemId = null;
        return "/details.jsf?faces-redirect=true";
    }
    public boolean isItemSelected(){
        return selectedItemId != null;
    }

    public void selectItem(long id){
        selectedItemId = id;
        items = itemService.getOnlyItem(selectedItemId);
    }

    public int getNumber_of_items() {
        return number_of_ranks;
    }

    public List<Item> getItems(){
        return itemService.getAllItems(false);
    }


}
