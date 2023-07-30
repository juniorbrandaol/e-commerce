package com.eblj.sistema._e_commerce.entities;

import com.eblj.sistema._e_commerce.enuns.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")//salva no banco com utc
  private Instant moment;
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private OrderStatus status;
  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;

  @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
  private Payment payment;

  public Order(){}

  public Order(long id, Instant moment, OrderStatus status, User client, Payment payment) {
    this.id = id;
    this.moment = moment;
    this.status = status;
    this.client = client;
    this.payment = payment;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public User getClient() {
    return client;
  }

  public void setClient(User client) {
    this.client = client;
  }

  public Payment getPayment() {
    return payment;
  }
}
