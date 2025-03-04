package org.example.felessmartket_be.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    Long id;

    @OneToOne
    @JoinColumn(name = "shipping_id")
    Shipping shipping;

    @OneToOne
    @JoinColumn(name = "payment_id")
    Payment payment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    Integer totalPrice;

    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

}
