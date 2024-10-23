export interface Student {
    id: number;
    prefix: string;
    firstname: string;
    lastname: string;
    countrycode: string;
    phone: string;
    email: string;
    password: string;
    addressline1: string;
    adressline2: string;
    city: string;
    state: string;
    zipcode: string;
    bachelorDegree: string;
    bachelorGPA: number | null;  
    md: string;
    mdGPA: number | null;       
    lookingForInternship: boolean;
    resume: File | null;         
    
  }
  