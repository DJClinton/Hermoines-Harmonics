import { CreditCard } from "./CreditCard";

export interface BuyerInfo {
    id: number;
    userid: number;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    paymentMethod: CreditCard;
  }
  