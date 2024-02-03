package com.syncgym.api.delivery.Subscription.entities;

import com.syncgym.api.delivery.CommonUser.entities.CommonUserEntity;
import com.syncgym.api.delivery.plan.entities.PlanEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "subscriptions")
public class SubscriptionEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "plan_id")
    private PlanEntity plan;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CommonUserEntity commonUser;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = true)
    private Date endDate;

    public SubscriptionEntity(Long id, PlanEntity plan, CommonUserEntity commonUser, Date startDate, Date endDate) {
        this.id = id;
        this.plan = plan;
        this.commonUser = commonUser;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SubscriptionEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlanEntity getPlan() {
        return plan;
    }

    public void setPlan(PlanEntity plan) {
        this.plan = plan;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CommonUserEntity getCommonUser() {
        return commonUser;
    }

    public void setCommonUser(CommonUserEntity commonUser) {
        this.commonUser = commonUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionEntity that = (SubscriptionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(plan, that.plan) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plan, startDate, endDate);
    }
}
