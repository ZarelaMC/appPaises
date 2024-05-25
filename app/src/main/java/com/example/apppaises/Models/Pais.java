package com.example.apppaises.Models;

import java.io.Serializable;

public class Pais implements Serializable {
    private String name;
    private Integer population;
    private Double area;
    private Flag flags;




    private String alpha2Code;
    private String alpha3Code;
    private String capital;
    private String subregion;
    private String region;
    private String demonym;
    private Double gini;
    private String nativeName;
    private String numericCode;
    private String flag;
    private String cioc;
    private Boolean independent;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAlpha2Code() {
        return alpha2Code;
    }
    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }
    public String getAlpha3Code() {
        return alpha3Code;
    }
    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getSubregion() {
        return subregion;
    }
    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public Integer getPopulation() {
        return population;
    }
    public void setPopulation(Integer population) {
        this.population = population;
    }
    public String getDemonym() {
        return demonym;
    }
    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }
    public Double getArea() {
        return area;
    }
    public void setArea(Double area) {
        this.area = area;
    }
    public Double getGini() {
        return gini;
    }
    public void setGini(Double gini) {
        this.gini = gini;
    }
    public String getNativeName() {
        return nativeName;
    }
    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }
    public String getNumericCode() {
        return numericCode;
    }
    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }
    public Flag getFlags() {
        return flags;
    }
    public void setFlags(Flag flag) {
        this.flags = flag;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public String getCioc() {
        return cioc;
    }
    public void setCioc(String cioc) {
        this.cioc = cioc;
    }
    public Boolean getIndependent() {
        return independent;
    }
    public void setIndependent(Boolean independent) {
        this.independent = independent;
    }
}
