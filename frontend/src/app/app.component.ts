import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Product } from './models/product.model';
import { ProductService } from './services/product.service';
import { ProductBlackFriday } from './models/product-black-friday.model';
import { ProductType } from './models/product-type.enum';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  products: ProductBlackFriday[] = [];
  newProduct: Product = {
    nomCommercial: '',
    type: ProductType.AUTRE,
    prixVenteInitial: 0
  };
  productTypes = Object.values(ProductType);

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getBlackFridayOffers().subscribe(data => {
      this.products = data;
    });
  }

  createProduct(): void {
    this.productService.createProduct(this.newProduct).subscribe(() => {
      this.loadProducts();
      this.newProduct = {
        nomCommercial: '',
        type: ProductType.AUTRE,
        prixVenteInitial: 0
      };
    });
  }

  deleteProduct(id: number): void {
    this.productService.deleteProduct(id).subscribe(() => {
      this.loadProducts();
    });
  }
}
