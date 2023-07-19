import { Component, Input } from '@angular/core';
import { BuyerInfoService } from '../buyerInfo.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { BuyerInfo } from '../type';

@Component({
  selector: 'app-buyerInfo-detail',
  templateUrl: './buyerInfo-detail.component.html',
  styleUrls: ['./buyerInfo-detail.component.scss'],
})
export class BuyerInfoDetailComponent {
  constructor(
    private route: ActivatedRoute,
    private buyerInfoService: BuyerInfoService,
    private location: Location
  ) {}

  @Input() buyerInfo?: BuyerInfo;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.getBuyerInfo(params['id']);
    });
    console.log(
      'ngonit buyer info: ' + this.buyerInfo + ' with id: ' + this.buyerInfo?.id
    );
  }

  getBuyerInfo(id: number): void {
    this.buyerInfoService
      .getBuyerInfo(id)
      .subscribe((buyerInfo) => (this.buyerInfo = buyerInfo));
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    if (this.buyerInfo) {
      this.buyerInfoService
        .updateBuyerInfo(this.buyerInfo)
        .subscribe(() => this.goBack());
    }
  }

  appendShippingAddress(shippingAddress: string): void {
    this.buyerInfo?.shippingAddresses.push(shippingAddress);
    this.buyerInfoService.updateBuyerInfo(this.buyerInfo);
  }

  appendCreditCard(holderName: string, cardNumber: number): void {
    this.buyerInfo?.creditCards.push({ holderName, cardNumber });
    this.buyerInfoService.updateBuyerInfo(this.buyerInfo);
  }
}
