## Postman How-To

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
- Copy-paste the "jwt" code in the response
- Press "Authorization" and change "Type" to 
- 

#### Find one User:
- (Copy-paste into url-postman-field:) http://localhost:8000/admin/selectone/
- after "/" please enter the ID-number for the user you are looking for
- Put request to "GET"

#### Find all Users:
- (Copy-paste into url-postman-field:) http://localhost:8000/admin/selectall
- Put request to "GET"

#### Update one User:
- Copy-paste into url-postman-field:
- Put request to "PUT"

#### Delete one User:
- Copy-paste into url-postman-field:
- Put request to "DELETE"

#### Add one Song:
- (Copy-paste into url-postman-field:) http://localhost:8000/songs/create
- Put request to "POST"
- Press "Body", "raw" and change "Text" to "JSON"
- Copy-paste into field: { "title":"put_title_here", "artist":"put_artist_here"}
- Change title-name and artist-name 

#### Find one Song:
- (Copy-paste into url-postman-field:) http://localhost:8000/songs/selectone/
- after "/" you add the id number of the song you're looking for
- Put request to "GET"

#### Find all Songs:
- (Copy-paste into url-postman-field:) http://localhost:8000/songs/selectall
- Put request to "GET"

#### Update one Song:
- Log in as an admin
- (Copy-paste into url-postman-field:)

#### Delete one Song:
- Log in as an admin

