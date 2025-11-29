import { ProductType } from "./product-type.enum";

export interface Product {
    id?: number;
    nomCommercial: string;
    type: ProductType;
    prixVenteInitial: number;
}
