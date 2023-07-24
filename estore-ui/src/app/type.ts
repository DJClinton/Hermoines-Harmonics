export interface Product {
  id: number;
  name: string;
  price: number;
  quantity: number;
}

export interface BuyerInfo {
  id: number;
  userid: number;
  firstName: string;
  lastName: string;
  phoneNumber: string;
  pastOrdersIds: Array<number>;
  creditCards: Array<CreditCard>;
  shippingAddresses: Array<String>;
  cart: Array<number>;
  wishlist: Array<number>;
}

export interface CreditCard {
  holderName: string;
  cardNumber: number;
}
