export interface Product {
  id: number;
  name: string;
  tags: string[];
  description: string;
  price: number;
  quantity: number;
  numClicks: number; // Used by popularity sort
  image?: string;
}

export interface BuyerInfo {
  id: number;
  userId: number;
  name: string;
  phoneNumber: string;
  pastOrdersIds: Array<number>;
  creditCards: Array<{ holderName: string, cardNumber: string }>;
  shippingAddresses: Array<String>;
  cart: Array<number>;
  wishlist: Array<number>;
}

export interface Cart{
  cart: Array<Product>;
}
