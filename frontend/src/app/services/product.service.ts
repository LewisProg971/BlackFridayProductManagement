import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product.model';
import { ProductBlackFriday } from '../models/product-black-friday.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl = 'http://localhost:8080/produits';

  constructor(private http: HttpClient) { }

  getBlackFridayOffers(): Observable<ProductBlackFriday[]> {
    return this.http.get<ProductBlackFriday[]>(`${this.apiUrl}/blackfriday`);
  }

  createProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.apiUrl, product);
  }

  deleteProduct(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
