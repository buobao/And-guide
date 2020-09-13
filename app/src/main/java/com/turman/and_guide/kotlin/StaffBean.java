package com.turman.and_guide.kotlin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class StaffBean {

    /**
     * Tags : 服务好,可信赖,够专业
     * StaffID : 4ad5ec3aa2784b01bce76db33ccc7fc3
     * StaffNo : AA149618
     * DomainAccount : zhanghui60
     * CnName : 张辉
     * Title :
     * PositionID : 0
     * Gender : M
     * Email : zhanghui60@centaline.com.cn
     * Mobile : 18217773371
     * MobileImport :
     * MobileBy400 : 4008188808,907131
     * Status : P
     * EmployDate : 1586448000
     * IsImported : false
     * CreateTime : 0
     * UpdateTime : 0
     * SPostNum : 123
     * RPostNum : 33
     * DPostNum : 34
     * HitCount : 1160
     * StoreID : 520
     * StoreName : 长阳三店分行
     * WorkYear : 2020
     * ServiceYear : 2020
     * GscopeID : 217409
     * RegionID : 2174
     * StaffImg : https://imgsh.centanet.com/shanghai/staticfile/agent/agentphoto/aa149618.jpg
     * TakeToSeeCount : 214
     * ServiceTimes : 1203
     * AttitudeScore : 100
     * ResponseScore : 100
     * ProfessionScore : 100
     * GscopeCn : 东外滩
     * RegionCn : 杨浦
     * Lng : 0
     * Lat : 0
     */

    private String Tags;
    private String StaffID;
    private String StaffNo;
    private String DomainAccount;
    private String CnName;
    private String Title;
    private int PositionID;
    private String Gender;
    private String Email;
    private String Mobile;
    private String MobileImport;
    private String MobileBy400;
    private String Status;
    private int EmployDate;
    private boolean IsImported;
    private int CreateTime;
    private int UpdateTime;
    private int SPostNum;
    private int RPostNum;
    private int DPostNum;
    private int HitCount;
    private int StoreID;
    private String StoreName;
    private int WorkYear;
    private int ServiceYear;
    private String GscopeID;
    private String RegionID;
    private String StaffImg;
    private String TakeToSeeCount;
    private int ServiceTimes;
    private int AttitudeScore;
    private int ResponseScore;
    private int ProfessionScore;
    private String GscopeCn;
    private String RegionCn;
    private int Lng;
    private int Lat;

    public String getTags() {
        return Tags;
    }

    public void setTags(String Tags) {
        this.Tags = Tags;
    }

    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public String getStaffNo() {
        return StaffNo;
    }

    public void setStaffNo(String StaffNo) {
        this.StaffNo = StaffNo;
    }

    public String getDomainAccount() {
        return DomainAccount;
    }

    public void setDomainAccount(String DomainAccount) {
        this.DomainAccount = DomainAccount;
    }

    public String getCnName() {
        return CnName;
    }

    public void setCnName(String CnName) {
        this.CnName = CnName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getPositionID() {
        return PositionID;
    }

    public void setPositionID(int PositionID) {
        this.PositionID = PositionID;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getMobileImport() {
        return MobileImport;
    }

    public void setMobileImport(String MobileImport) {
        this.MobileImport = MobileImport;
    }

    public String getMobileBy400() {
        return MobileBy400;
    }

    public void setMobileBy400(String MobileBy400) {
        this.MobileBy400 = MobileBy400;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getEmployDate() {
        return EmployDate;
    }

    public void setEmployDate(int EmployDate) {
        this.EmployDate = EmployDate;
    }

    public boolean isIsImported() {
        return IsImported;
    }

    public void setIsImported(boolean IsImported) {
        this.IsImported = IsImported;
    }

    public int getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(int CreateTime) {
        this.CreateTime = CreateTime;
    }

    public int getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(int UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public int getSPostNum() {
        return SPostNum;
    }

    public void setSPostNum(int SPostNum) {
        this.SPostNum = SPostNum;
    }

    public int getRPostNum() {
        return RPostNum;
    }

    public void setRPostNum(int RPostNum) {
        this.RPostNum = RPostNum;
    }

    public int getDPostNum() {
        return DPostNum;
    }

    public void setDPostNum(int DPostNum) {
        this.DPostNum = DPostNum;
    }

    public int getHitCount() {
        return HitCount;
    }

    public void setHitCount(int HitCount) {
        this.HitCount = HitCount;
    }

    public int getStoreID() {
        return StoreID;
    }

    public void setStoreID(int StoreID) {
        this.StoreID = StoreID;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String StoreName) {
        this.StoreName = StoreName;
    }

    public int getWorkYear() {
        return WorkYear;
    }

    public void setWorkYear(int WorkYear) {
        this.WorkYear = WorkYear;
    }

    public int getServiceYear() {
        return ServiceYear;
    }

    public void setServiceYear(int ServiceYear) {
        this.ServiceYear = ServiceYear;
    }

    public String getGscopeID() {
        return GscopeID;
    }

    public void setGscopeID(String GscopeID) {
        this.GscopeID = GscopeID;
    }

    public String getRegionID() {
        return RegionID;
    }

    public void setRegionID(String RegionID) {
        this.RegionID = RegionID;
    }

    public String getStaffImg() {
        return StaffImg;
    }

    public void setStaffImg(String StaffImg) {
        this.StaffImg = StaffImg;
    }

    public String getTakeToSeeCount() {
        return TakeToSeeCount;
    }

    public void setTakeToSeeCount(String TakeToSeeCount) {
        this.TakeToSeeCount = TakeToSeeCount;
    }

    public int getServiceTimes() {
        return ServiceTimes;
    }

    public void setServiceTimes(int ServiceTimes) {
        this.ServiceTimes = ServiceTimes;
    }

    public int getAttitudeScore() {
        return AttitudeScore;
    }

    public void setAttitudeScore(int AttitudeScore) {
        this.AttitudeScore = AttitudeScore;
    }

    public int getResponseScore() {
        return ResponseScore;
    }

    public void setResponseScore(int ResponseScore) {
        this.ResponseScore = ResponseScore;
    }

    public int getProfessionScore() {
        return ProfessionScore;
    }

    public void setProfessionScore(int ProfessionScore) {
        this.ProfessionScore = ProfessionScore;
    }

    public String getGscopeCn() {
        return GscopeCn;
    }

    public void setGscopeCn(String GscopeCn) {
        this.GscopeCn = GscopeCn;
    }

    public String getRegionCn() {
        return RegionCn;
    }

    public void setRegionCn(String RegionCn) {
        this.RegionCn = RegionCn;
    }

    public int getLng() {
        return Lng;
    }

    public void setLng(int Lng) {
        this.Lng = Lng;
    }

    public int getLat() {
        return Lat;
    }

    public void setLat(int Lat) {
        this.Lat = Lat;
    }
}
