import { Component, Input } from '@angular/core';
import { Product } from '../../type';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../../product.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss'],
})
export class ProductDetailComponent {
  @Input() product?: Product;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.getProduct(params['id']);
    });
  }

  getProduct(id: number): void {
    this.productService
      .getProduct(id)
      .subscribe((product) => (this.product = product));
  }

  goBack(): void {
    this.location.back();
  }
}
