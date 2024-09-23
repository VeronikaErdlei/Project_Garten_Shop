/*package org.example.Tests;

import org.example.service.FavoriteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FavoriteServiceTest {

    @Autowired
    private FavoriteService favoriteService;

    @MockBean
    private FavoriteRepository favoriteRepository;

    @Test
    public void testAddFavorite() {
        User user = new User();
        Product product = new Product();

        favoriteService.addFavorite(user, product);
        Mockito.verify(favoriteRepository).save(Mockito.any(Favorite.class));
    }

    @Test
    public void testGetFavorites() {
        User user = new User();
        Product product = new Product();
        Favorite favorite = new Favorite();
        favorite.setProduct(product);

        Mockito.when(favoriteRepository.findByUser(user)).thenReturn(Collections.singletonList(favorite));

        List<Product> favorites = favoriteService.getFavorites(user);
        assertEquals(1, favorites.size());
        assertEquals(product, favorites.get(0));
    }

    @Test
    public void testRemoveFavorite() {
        User user = new User();
        Product product = new Product();
        Favorite favorite = new Favorite();
        favorite.setProduct(product);

        Mockito.when(favoriteRepository.findByUser(user)).thenReturn(Collections.singletonList(favorite));

        favoriteService.removeFavorite(user, product);
        Mockito.verify(favoriteRepository).delete(favorite);
    }
}

 */
