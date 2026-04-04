package com.bankpay.model;

public class Payment {
    private String id;
    private String from;
    private String to;
    private Double amount;
    private String status;

    public Payment() {}

    public Payment(String id, String from,
                   String to, Double amount, String status) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
