import { Component, Input } from '@angular/core';
import { BuyerInfoService } from '../buyerInfo.service';
import { ActivatedRoute } from '@angular/router';
import { BuyerInfo } from '../buyerInfo';
import { Location } from '@angular/common';

@Component({
  selector: 'app-buyerInfo-detail',
  templateUrl: './buyerInfo-detail.component.html',
  styleUrls: ['./buyerInfo-detail.component.scss']
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
      this.buyerInfoService.updateBuyerInfo(this.buyerInfo)
        .subscribe(() => this.goBack());
    }
  }


}
