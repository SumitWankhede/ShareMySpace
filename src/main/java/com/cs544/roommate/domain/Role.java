/**
 * Created by Amartuvshin Bold on 2018-04-21.
 */
package com.cs544.roommate.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue
    @Column(name="id")
	private int id;
	@Column(name="name")
	private String name;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}