# The Distance Android Technical Test

Author: Iain Richardson

Date: 13/09/2017

## Compatibility
- Target SDK: 26
- Minimum SDK: 15

## Assumptions
- "Within here display the contents of the html field provided in the JSON": The description html field has been displayed in the Detail View as I believed this was sufficient enough.

## Features

- Events list screen: Endless/Infinite Scrolling of events. An API call for the next events page is made once the current scrolling position has 8 rows/events below it;
- Event screen: Displays the title of the event in the toolbar, html event description and a "See More" button to take the user to the appropriate Eventbrite web page.

## Architecture and Testing

The general approach I have taken is to implement the `Model-View-Presenter Architecture` (MVP) in order to split "Android code" from "pure Java code", and make the App as "unit-testable" as possible. An area where I have left unit testing is the `EventsRecyclerviewAdapter` as in my experience running tests which involve `Robolectric` can cause memory issues especially on the likes of `CircleCI`. Test coverage of this class could come from UI/Espresso tests.

No UI/Espresso tests have been provided as I feel the size of the app does not warrant such tests, especially as they are slow and sometimes flaky. However, `Dagger 2` has been used as an Dependency Injection library and it would therefore be possible to write UI tests if more features were added. This can be done by creating test components and modules and then, for example, mocking the DataManger to mock an API call and it's subsequent response.
# MVP-Example2
