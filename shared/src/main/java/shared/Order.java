package shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable{
    private String id;
    private String name;
    private String contact;
    private ArrayList<Items> items;
    private int quantity;



}

