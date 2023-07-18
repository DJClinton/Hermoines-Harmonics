import { Component } from '@angular/core';
import { BuyerInfoService } from '../buyerInfo.service';
import { BuyerInfo } from '../buyerInfo';
import { CreditCard } from '../CreditCard';

@Component({
  selector: 'app-buyerInfos',
  templateUrl: './buyerInfos.component.html',
  styleUrls: ['./buyerInfos.component.scss'],
})
export class BuyerInfosComponent {
  buyerInfos: BuyerInfo[] = [];

  firstName: string = '';
  lastName: string = '';
  phoneNumber: number = 1000000000;

  constructor(private buyerInfoService: BuyerInfoService) {}

  ngOnInit() {
    this.getBuyerInfos();
  }

  getBuyerInfos() {
    this.buyerInfoService.getBuyerInfos().subscribe((buyerInfos) => {
      this.firstName = buyerInfos[0].firstName;
      this.lastName = buyerInfos[0].lastName;
      this.phoneNumber = buyerInfos[0].phoneNumber;
    });
  }

  addBuyerInfo(
    userid: number,
    firstName: string,
    lastName: string,
    phoneNumber: string,
    pastOrderIds: Array<number>,
    creditCards: Array<CreditCard>,
    shippingAddresses: Array<String>,
    cart: Array<number>,
    wishlist: Array<number>
  ) {
    const id: number = 0; // Server will handle the actual buyerInfo ID, replacing this temporary value.
    const newBuyerInfo: BuyerInfo = {
      id,
      userid,
      firstName,
      lastName,
      phoneNumber,
      pastOrderIds,
      creditCards,
      shippingAddresses,
      cart,
      wishlist,
    };
    this.buyerInfoService
      .addBuyerInfo(newBuyerInfo)
      .subscribe((buyerInfo: BuyerInfo) => {
        this.buyerInfos.push(buyerInfo);
        this.getBuyerInfos(); // Refreshes buyerInfo list
        console.log('BuyerInfo created successfully');
      });
  }

  addNewBuyerInfo(
    userid: number,
    firstName: string,
    lastName: string,
    phoneNumber: string
  ) {
    this.addBuyerInfo(
      userid,
      firstName,
      lastName,
      phoneNumber,
      [],
      [],
      [],
      [],
      []
    );
  }

  updateBuyerInfo(buyerInfo: BuyerInfo) {
    this.buyerInfoService.updateBuyerInfo(buyerInfo).subscribe(() => {
      this.getBuyerInfos();
      console.log('BuyerInfo updated successfully');
    });
  }

  deleteBuyerInfo(id: number) {
    this.buyerInfoService.deleteBuyerInfo(id).subscribe(() => {
      this.getBuyerInfos();
      console.log('BuyerInfo deleted successfully');
    });
  }
}
