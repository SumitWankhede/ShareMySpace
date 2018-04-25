/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */
package com.cs544.roommate.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name="NAME")
    private String name;

    @Column(name = "EMAIL", unique = true)
    @NotNull
    private String email;

    @Column(name="PHONE")
    private String phone;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="PRICE")
    private int price;

    @Column(name="AGE")
    private int age;

    @Column(name="GENDER")
    private String gender;
    @Column(name="enabled")
    private boolean enabled;

    @Transient
    private Integer role;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles = new ArrayList<Role>();

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews = new ArrayList<Review>();
	
	/*@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Property> properties = new ArrayList<Property>();*/

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addRole(Role role) {
        if (!this.roles.contains(role)) {
            this.roles.add(role);
        }
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void clearRoles() {
        for (Role role : roles) {
            role.getUsers().clear();
        }
        roles.clear();
    }
    
  //Convenience method
  //Added by Romie on 2018-04-24
  	public void addReview(Review review) {
  		reviews.add(review);
  		review.setUser(this);
  	}

  	public void removeReview(Review review) {
  		review.setUser(null);
  		this.reviews.remove(review);
  	}
  	public List<Review> getReviews() {
  		return Collections.unmodifiableList(reviews);
  	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                price == user.price &&
                age == user.age &&
                enabled == user.enabled &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email, phone, password, price, age, enabled, role);
    }
}
