package sanix.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    @ManyToMany(mappedBy="authors")
    private Set<Book> books =new HashSet<>();



    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getName(){return name;}

    public void setName(String name){this.name=name;}

    public String getAdress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }
}
