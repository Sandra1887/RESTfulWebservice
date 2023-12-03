## Postman-how-To

#### Register a new User:
- (Copy-paste into url-postman-field:) http://localhost:8000/auth/register
- Put request to "POST"
- Press "Body", "raw" and change "Text" to "JSON"
- Copy-paste into field: {"username":"enter_username_here, "password":"enter_password_here"}

#### Login as a User:
- (Copy-paste into url-postman-field:) http://localhost:8000/auth/login
- Put request to "POST"
- - Press "Body", "raw" and change "Text" to "JSON"
- Copy-paste into field: {"username":"enter_username_here, "password":"enter_password_here"}
- Press "Send"
- Copy your recieved jwt-token to authenticate for PUT and DELETE

#### Find one User:
- (Copy-paste into url-postman-field:) http://localhost:8000/admin/selectone/
  - after "/" please enter the ID-number for the user you are looking for
- Change request to "GET"

#### Find all Users:
- (Copy-paste into url-postman-field:) http://localhost:8000/admin/selectall
- Change request to "GET"

#### Update User: (Authentication needed)
- Copy-paste into url-postman-field: http://localhost:8000/admin/update/
  - after "/" please enter the ID-number for the user you want to update
- Change request to "PUT"
- As a body: Put in the new values for the user
- Press "Authentication" and change Type to "Bearer Token" - put in your copied jwt-token
- Press "Send"

#### Delete User: (Authentication needed)
- Copy-paste into url-postman-field: http://localhost:8000/admin/delete/
  - after "/" please enter the ID-number for the user you want to delete
- Change request to "DELETE"
- Press "Authentication" and change Type to "Bearer Token" - put in your copied jwt-token
- Press "Send"

#### Add one Song:
- (Copy-paste into url-postman-field:) http://localhost:8000/songs/create
- Put request to "POST"
- Press "Body", "raw" and change "Text" to "JSON"
- Copy-paste into field: { "title":"put_title_here", "artist":"put_artist_here"}
- Change title-name and artist-name 

#### Find one Song:
- (Copy-paste into url-postman-field:) http://localhost:8000/songs/selectone/
  - after "/" you add the id number of the song you're looking for
- Change request to "GET"

#### Find all Songs:
- (Copy-paste into url-postman-field:) http://localhost:8000/songs/selectall
- Change request to "GET"

#### Update one Song: (Authentication needed)
- (Copy-paste into url-postman-field:) http://localhost:8000/songs/update/
  - after "/" enter the id of the song you want to update
- Change request to "PUT"
- Press "Authentication" and change Type to "Bearer Token" - put in your copied jwt-token
- Press "Send"

#### Delete one Song: (Authentication needed)
- (Copy-paste into url-postman-fiend:) http://localhost:8000/songs/delete/
  - after "/" enter the id of the song you want to delete
- Change request to "DELETE"
- Press "Authentication" and chane Type to "Bearer Token" - put in your copied jwt-token
- Send
