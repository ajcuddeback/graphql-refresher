import { Component } from '@angular/core';
import { gql } from '@apollo/client/core';
import { Apollo } from 'apollo-angular';
const GET_BOOKS = gql`
{
  books {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}
`;

@Component({
  selector: 'app-book',
  standalone: true,
  imports: [],
  templateUrl: './book.component.html',
  styleUrl: './book.component.scss'
})
export class BookComponent {
  books: any[] = [];
  loading = true;
  error: any;

  constructor(private readonly apollo: Apollo) {}

  ngOnInit(): void {
    this.apollo.watchQuery(
      {
        query: GET_BOOKS
      }
    ).valueChanges.subscribe((result: any) => {
      this.books = result.data?.books;
      this.loading = result.loading;
      this.error = result.error;
    });
  }

}
