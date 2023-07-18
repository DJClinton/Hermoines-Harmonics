import { CreditCard } from "./CreditCard";

// export interface BuyerInfo {
//     id: number;
//     userid: number;
//     firstName: string;
//     lastName: string;
//     phoneNumber: string;
//     pastOrderIds: Array<number>;
//     creditCards: Array<CreditCard>;
//     shippingAddresses: Array<String>;
//     cart: Array<number>;
//     wishlist: Array<number>;
//   }

export class BuyerInfo {
    id: number;
    userid: number;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    pastOrderIds: Array<number>;
    creditCards: Array<CreditCard>;
    shippingAddresses: Array<String>;
    cart: Array<number>;
    wishlist: Array<number>;

    constructor(id: number,
      userid: number,
      firstName: string,
      lastName: string,
      phoneNumber: string,
      pastOrderIds: Array<number>,
      creditCards: Array<CreditCard>,
      shippingAddresses: Array<String>,
      cart: Array<number>,
      wishlist: Array<number>) {
        this.id = id;
        this.userid = userid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.pastOrderIds = pastOrderIds;
        this.creditCards = creditCards;
        this.shippingAddresses = shippingAddresses;
        this.cart = cart;
        this.wishlist = wishlist;
    }
  }


  