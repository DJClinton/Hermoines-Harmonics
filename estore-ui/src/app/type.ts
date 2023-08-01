export interface Product {
  id: number;
  name: string;
  tags: string[];
  description: string;
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

export interface Order{
  id: number;
  uid: number;
  productIds: number[];
  date: Date;
  orderStatus: OrderStatus;
  ccDigits: number;
  address: string;
}

enum OrderStatus{
    UNPROCESSED,
    SHIPPED,
    DELIVERD,
    CANCELLED
}