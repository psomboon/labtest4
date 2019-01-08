package com.example.demo.entity;

import io.micrometer.core.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Table(name="Photocollection")
public class Photocollection {



    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="Photocollection_seq",sequenceName="Photocollection_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Photocollection_seq")
    @Column(name="Photocollection_ID",unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull Date startdate;
    private @NonNull Date lastdate;
    private @NonNull String membername;
    private @NonNull String photoseriesname;
    private @NonNull String promotionphotocollectionname;
    private @NonNull String shootingstylename;
    public void setMembername(String membername){ this.membername=membername; }
    public String getMembername(){return membername;}
    public void setPhotoseriesname(String photoseriesname) { this.photoseriesname = photoseriesname;  }
    public String getPhotoseriesname() { return photoseriesname;  }
    public void setPromotionphotocollectionname(String promotionphotocollectionname) { this.promotionphotocollectionname = promotionphotocollectionname; }
    public String getPromotionphotocollectionname() { return promotionphotocollectionname; }
    public void setShootingstylename(String shootingstylename) { this.shootingstylename = shootingstylename; }
    public String getShootingstylename() {  return shootingstylename;  }


    public void id(Long id) { this.id = id; }
    public Long id() { return id; }
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }
    public Date getStartdate() {
        return startdate;
    }
    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }
    public Date getLastdate() { return lastdate; }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "Member_ID", insertable = true)
    private Member member;
    
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Photoseries.class)
    @JoinColumn(name = "Photoseries_ID", insertable = true)
    private Photoseries photoseries;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Promotionphotocollection.class)
    @JoinColumn(name = "Promotionphotocollection_ID", insertable = true)
    private Promotionphotocollection promotionphotocollection ;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Shootingstyle.class)
    @JoinColumn(name = "Shootingstyle_ID", insertable = true)
    private Shootingstyle shootingstyle ;

    public Photocollection(){}
    public Photocollection(Date startdate,Date lastdate,Member member,Photoseries photoseries
            ,Promotionphotocollection promotionphotocollection,Shootingstyle shootingstyle){
        this.startdate=startdate;
        this.lastdate=lastdate;
        this.member=member;
        this.photoseries=photoseries;
        this.promotionphotocollection=promotionphotocollection;
        this.shootingstyle=shootingstyle;
    }


    public void setMember(Member member) {this.member=member; }
    public Member getMember(){return  member;}
    public void setPhotoseries(Photoseries photoseries){ this.photoseries=photoseries; }
    public Photoseries getPhotoseries(){return photoseries;}
    public void setPromotionphotocollection(Promotionphotocollection promotionphotocollection){ this.promotionphotocollection=promotionphotocollection; }
    public Promotionphotocollection getPromotionphotocollection(){ return  promotionphotocollection; }
    public void setShootingstyle(Shootingstyle shootingstyle){ this.shootingstyle=shootingstyle; }
    public Shootingstyle getShootingstyle(){return shootingstyle;}


}
